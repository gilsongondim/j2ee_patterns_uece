import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswersCreateComponent } from './answers-create.component';

describe('AnswersCreateComponent', () => {
  let component: AnswersCreateComponent;
  let fixture: ComponentFixture<AnswersCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnswersCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswersCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
