import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswersUpdateComponent } from './answers-update.component';

describe('AnswersUpdateComponent', () => {
  let component: AnswersUpdateComponent;
  let fixture: ComponentFixture<AnswersUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnswersUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswersUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
